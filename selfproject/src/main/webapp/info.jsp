<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.parkingDao"%>
<%@page import="domain.parking"%>
<%@page import="java.util.List"%>
<%@page import="dao.parkingDaoImpl"%>

<%
    // parkingDaoImpl의 selectAll 메서드를 사용하여 List<parking>을 가져옵니다.
    parkingDao parkingDaoImpl = new parkingDaoImpl();
    List<parking> parkingList = parkingDaoImpl.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>다양한 이미지 마커 표시하기</title>
     <style>
    .wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
    .wrap * {padding: 0;margin: 0;}
    .wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
    .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
    .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
    .info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
    .info .close:hover {cursor: pointer;}
    .info .body {position: relative;overflow: hidden;}
    .info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
    .desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
    .desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
    .info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
    .info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
    .info .link {color: #5085BB;}
</style>

</head>
<body>
<div id="mapwrap">
    <!-- 지도가 표시될 div -->
    <div id="map" style="width: 100%; height: 550px;"></div>
    <!-- 지도 위에 표시될 마커 카테고리 -->
    <div class="category">
        <ul>
            <li id="carparkMenu" onclick="changeMarker('carpark')">
                <span class="ico_comm ico_carpark"></span>
                주차장
            </li>
        </ul>
    </div>
</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fa6166e65f0014461bc6abfc1d3cad77"></script>
<script>
    var mapContainer = document.getElementById('map'); // 지도를 표시할 div
    var mapOption = {
        center: new kakao.maps.LatLng(37.511936931516, 127.055373081864), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

    // 지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption);

    // 주차장 객체 리스트
    var parkingList = [
    <% for (int i=0; i<parkingList.size(); i++) { %>
    {
        name: '<%= parkingList.get(i).getName() %>',
        address: '<%= parkingList.get(i).getAddr() %>',
        latlng: new kakao.maps.LatLng(<%= parkingList.get(i).getLatitude() %>, <%= parkingList.get(i).getLongitude() %>)
    },
    <% } %>
    ];

    // 마커 이미지의 이미지 주소입니다
    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png';

    // 마커 이미지의 이미지 크기입니다
    var imageSize = new kakao.maps.Size(24, 35);

    // 마커 이미지를 생성합니다
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

    // 마커를 생성하고 지도위에 표시하는 함수입니다
    function addMarker(position, image) {
        var marker = new kakao.maps.Marker({
            position: position,
            image: image
        });

        marker.setMap(map);
        return marker;
    }

    // 주차장 마커를 표시할 카테고리를 변경하는 함수입니다
    function changeMarker(category) {
        // 카테고리에 따라 마커를 표시하거나 삭제합니다
        for (var i = 0; i < parkingList.length; i++) {
            var marker = parkingList[i].marker;
        }
    }

    // 마커와 커스텀 오버레이를 생성하고 지도위에 표시하는 함수입니다
    function createMarkerOverlay() {
        for (var i = 0; i < parkingList.length; i++) {
            var parking = parkingList[i];
            var position = parking.latlng;
            var marker = addMarker(position, markerImage, iwContent);
            parking.marker = marker;

            // 커스텀 오버레이에 표시할 컨텐츠를 생성합니다
            var iwContent =
                '<div class="customoverlay">' +
                '    <div class="info">' +
                '        <div class="title">' +
                '            ' + parking.name +
                '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' +
                '        </div>' +
                '        <div class="body">' +
                '            <div class="img">' +
                '                <img src="https://media.istockphoto.com/id/1268257891/ko/%EB%B2%A1%ED%84%B0/%ED%9D%B0%EC%83%89-%EB%8C%80%EB%AC%B8%EC%9E%90-p%EC%99%80-%ED%8C%8C%EB%9E%80%EC%83%89-%EC%82%AC%EA%B0%81%ED%98%95-%EC%A3%BC%EC%B0%A8-%ED%91%9C%EC%A7%80%ED%8C%90.jpg?s=612x612&w=0&k=20&c=COylsmqtONwhOD_Hy8WKgkNbg3H3tQ5XErQWZiHzXg0=" width="73" height="70">' +
                '           </div>' +
                '            <div class="desc">' +
                '                <div class="ellipsis">' + parking.address + '</div>' +
                '                <div><a href="http://map.daum.net/link/search/' + parking.address + '" target="_blank" class="link">길찾기</a></div>' +
                '            </div>' +
                '        </div>' +
                '    </div>' +
                '</div>';
                
                iwRemoveable = false; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
                
                var infowindow = new kakao.maps.InfoWindow({
                    content: iwContent,
                    removable: iwRemoveable
                });

            // 마커 위에 커스텀 오버레이를 표시합니다
           var overlay = new kakao.maps.CustomOverlay({
                content: iwContent,
                map: map,
                position: marker.getPosition(),
                yAnchor: 1,
            });
            parking.overlay = overlay;
            
            (function(marker, infowindow) {
            // 마커에 클릭이벤트를 등록합니다
            kakao.maps.event.addListener(marker, 'click', function() {
                // 마커 위에 인포윈도우를 표시합니다
                infowindow.open(map, marker);
            });
            
            kakao.maps.event.addListener(map, 'click', function() {
                infowindow.close();
            });
        })(marker, infowindow);
            
        }
    }

    // 커스텀 오버레이를 닫기 위해 호출되는 함수입니다
    function closeOverlay() {
        for (var i = 0; i < parkingList.length; i++) {
            var parking = parkingList[i];
            if (parking.overlay) {
                parking.overlay.setMap(null);
            }
        }
    }

    // 마커와 커스텀 오버레이를 생성하고 표시합니다
    createMarkerOverlay();
</script>
</body>
</html>
