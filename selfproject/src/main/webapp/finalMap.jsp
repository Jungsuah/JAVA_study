<%@page import="dao.parkingDao"%>
<%@page import="domain.parking"%>
<%@page import="java.util.List"%>
<%@page import="dao.parkingDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>마커 생성하기</title>
    <style>
        #map {
            width: 100%;
            height: 350px;
        }
    </style>
</head>
<body>
<div id="map"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fa6166e65f0014461bc6abfc1d3cad77"></script>
<script>
    var mapContainer = document.getElementById('map');
    var mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 3
    };

    var map = new kakao.maps.Map(mapContainer, mapOption);

    // JSP에서 받아온 마커 정보를 JavaScript 배열로 설정합니다.
    var markers = [
        <%
            // parkingDaoImpl의 selectAll 메서드를 사용하여 List<parking>을 가져옵니다.
            parkingDao parkingDaoImpl = new parkingDaoImpl();
            List<parking> parkingList = parkingDaoImpl.selectAll();

            // 각 parking 객체의 latitude와 longitude를 사용하여 마커 정보를 설정합니다.
            for (parking parking : parkingList) {
                // 마커 정보를 JavaScript 형식으로 출력합니다.
        %>
        {
            lat: <%= parking.getLatitude() %>,
            lng: <%= parking.getLongitude() %>
        },
        <%
            }
        %>
    ];

    // 마커를 생성하고 지도 위에 표시합니다.
    for (var i = 0; i < markers.length; i++) {
        var markerPosition = new kakao.maps.LatLng(markers[i].lat, markers[i].lng);

        var marker = new kakao.maps.Marker({
            position: markerPosition
        });

        marker.setMap(map);
    }
</script>
</body>
</html>
