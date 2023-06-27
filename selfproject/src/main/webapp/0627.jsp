<%@page import="domain.parking"%>
<%@page import="dao.parkingDaoImpl"%>
<%@page import="dao.parkingDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%
//parkingDaoImpl의 selectAll 메서드를 사용하여 List<parking>을 가져옵니다.
parkingDao parkingDaoImpl = new parkingDaoImpl();
List<parking> parkingList = parkingDaoImpl.selectAll();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>이미지 마커와 커스텀 오버레이</title>
    <!-- 스타일과 스크립트 등 생략 -->
<style>
    .overlay_info {border-radius: 6px; margin-bottom: 12px; float:left;position: relative; border: 1px solid #ccc; border-bottom: 2px solid #ddd;background-color:#fff;}
    .overlay_info:nth-of-type(n) {border:0; box-shadow: 0px 1px 2px #888;}
    .overlay_info a {display: block; background: #d95050; background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px center; text-decoration: none; color: #fff; padding:12px 36px 12px 14px; font-size: 14px; border-radius: 6px 6px 0 0}
    .overlay_info a strong {background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/place_icon.png) no-repeat; padding-left: 27px;}
    .overlay_info .desc {padding:14px;position: relative; min-width: 190px; height: 56px}
    .overlay_info img {vertical-align: top;}
    .overlay_info .address {font-size: 12px; color: #333; position: absolute; left: 80px; right: 14px; top: 24px; white-space: normal}
    .overlay_info:after {content:'';position: absolute; margin-left: -11px; left: 50%; bottom: -12px; width: 22px; height: 12px; background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png) no-repeat 0 bottom;}
</style>
</head>
<body>
    <div id="map" style="width: 100%; height:700px;"></div>

    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fa6166e65f0014461bc6abfc1d3cad77"></script>
    <script>
        var mapContainer = document.getElementById('map');
        var mapOptions = {
            center: new kakao.maps.LatLng(<%= parkingList.get(0).getLatitude()%>,<%= parkingList.get(0).getLongitude()%> ),
            level: 3,
            mapTypeId: kakao.maps.MapTypeId.ROADMAP
        };

        var map = new kakao.maps.Map(mapContainer, mapOptions);

        var positions = [];
        var parkingList = [
            <% for (int i=0; i<parkingList.size(); i++) { %>
            {
                name: '<%= parkingList.get(i).getName() %>',
                addr: '<%= parkingList.get(i).getAddr() %>',
                latlng: new kakao.maps.LatLng(<%= parkingList.get(i).getLatitude() %>, <%= parkingList.get(i).getLongitude() %>)
            },
            <% } %>
        ];

        for (var i = 0; i < parkingList.length; i++) {
            var parking = parkingList[i];
            var position = {
                "name": parking.name,
                "addr": parking.addr,
                "latlng": parking.latlng // 이미 LatLng 객체로 생성되었으므로 다시 생성할 필요가 없습니다.
            };
            positions.push(position);
        }

        var markerImageUrl = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png";
        var markerImageSize = new kakao.maps.Size(40, 42);
        var markerImageOptions = {
            offset: new kakao.maps.Point(20, 42)
        };

        var imageSize = new kakao.maps.Size(24, 35);
        var markerImage = new kakao.maps.MarkerImage(markerImageUrl, imageSize);

        for (var i = 0; i < positions.length; i++) {
            var data = positions[i];
            displayMarker(data);
        }

        function displayMarker(data) {
            var marker = new kakao.maps.Marker({
                map: map,
                position: data.latlng,
                image: markerImage
            });

            var overlay = new kakao.maps.CustomOverlay({
                yAnchor: 1,
                xAnchor: -0.2,
                position: marker.getPosition()
            });

            var content = document.createElement('div');
            content.className = 'overlay_info';
            content.innerHTML = '<a href="https://place.map.kakao.com/17600274" target="_blank"><strong>'+data.name+'</strong></a>' +
                                '<div class="desc">' +
                                '    <img src="https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/place_thumb.png" alt="">' +
                                '    <span class="address">'+ data.addr +'</span>' +
                                '</div>';
            
            var closeBtn = document.createElement('button');
            closeBtn.innerHTML = 'x';
            closeBtn.style.cssText = 'background: rgba(0, 0, 0, 0); color: rgba(0, 0, 0, 0); border: none ';
            closeBtn.onclick = function () {
                overlay.setMap(null);
            };
            
            var infoWrapper = document.createElement('div');
            infoWrapper.className = 'wrap';
            infoWrapper.appendChild(content);
            infoWrapper.appendChild(closeBtn);
            
            overlay.setContent(infoWrapper);

            kakao.maps.event.addListener(marker, 'click', function () {
                overlay.setMap(map);
            });
        }
    </script>
</body>
</html>
