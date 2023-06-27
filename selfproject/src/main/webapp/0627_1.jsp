<%@page import="domain.parking"%>
<%@page import="java.util.List"%>
<%@page import="dao.parkingDaoImpl"%>
<%@page import="dao.parkingDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="utf-8">
<title>마커 클러스터러 사용하기</title>
</head>
<body>
<div id="map" style="width:100%;height:700px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fa6166e65f0014461bc6abfc1d3cad77&libraries=clusterer"></script>
<script>
    var map = new kakao.maps.Map(document.getElementById('map'), {
        center: new kakao.maps.LatLng(36.2683, 127.6358),
        level: 10
    });

    var clusterer = new kakao.maps.MarkerClusterer({
        map: map,
        averageCenter: true,
        minLevel: 10
    });

    var positions = [
        <%
        parkingDao parkingDaoImpl = new parkingDaoImpl();
        List<parking> parkingList = parkingDaoImpl.selectAll();
        for (parking parking : parkingList) {
        %>
        new kakao.maps.LatLng(<%= parking.getLatitude() %>, <%= parking.getLongitude() %>),
        <%
        }
        %>
    ];

    var markers = positions.map(function(position) {
        return new kakao.maps.Marker({
            position: position
        });
    });

    clusterer.addMarkers(markers);
</script>
</body>
</html>
