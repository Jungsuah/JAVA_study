<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>주차장 위치 검색하기</title>
</head>
<body>
    <div id="map" style="width:100%;height:350px;"></div>

    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fa6166e65f0014461bc6abfc1d3cad77"></script>
    <script>
        // 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
        var infowindow = new kakao.maps.InfoWindow({zIndex:1});

        var mapContainer = document.getElementById('map'); // 지도를 표시할 div
        var mapOption = {
            center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };  

        // 지도를 생성합니다    
        var map = new kakao.maps.Map(mapContainer, mapOption); 

        // AJAX를 통해 MySQL에서 주차장 주소 데이터를 가져옵니다
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    var parkingData = JSON.parse(xhr.responseText);
                    displayParkingMarkers(parkingData);
                } else {
                    console.error('Request failed. Status:', xhr.status);
                }
            }
        };
        xhr.open('GET', 'array.jsp', true);
        xhr.send();

        // 주차장 데이터를 기반으로 마커를 생성하고 지도에 표시하는 함수입니다
        function displayParkingMarkers(data) {
            // 검색된 주차장 위치를 기준으로 지도 범위를 재설정하기 위해
            // LatLngBounds 객체에 좌표를 추가합니다
            var bounds = new kakao.maps.LatLngBounds();

            for (var i = 0; i < data.length; i++) {
                var place = data[i];
                var markerPosition = new kakao.maps.LatLng(place.latitude, place.longitude);
                var marker = new kakao.maps.Marker({
                    map: map,
                    position: markerPosition
                });

                // 마커에 클릭 이벤트를 등록합니다
                kakao.maps.event.addListener(marker, 'click', (function(marker, place) {
                    return function() {
                        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
                        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
                        infowindow.open(map, marker);
                    };
                })(marker, place));

                bounds.extend(markerPosition);
            }

            // 검색된 주차장 위치를 기준으로 지도 범위를 재설정합니다
            map.setBounds(bounds);
        }
    </script>
</body>
</html>
