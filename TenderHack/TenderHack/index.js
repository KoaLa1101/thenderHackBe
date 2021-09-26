document.addEventListener("DOMContentLoaded", onCreate);

function onCreate() {
    popUpHide();
    // addItem('{\"name\": \"Ручка шариковая CORVINA (Италия) 51 Classic, корпус прозрачный, узел 1 мм, линия 0,7 мм, синяя\"}', true);
    // addItem('{\"name\": \"Ручка шариковая CORVINA (Италия) 51 Classic, корпус прозрачный, узел 1 мм, линия 0,7 мм, синяя\"}', true);
    // addItem('{\"name\": \"Ручка шариковая CORVINA (Италия) 51 Classic, корпус прозрачный, узел 1 мм, линия 0,7 мм, синяя\"}', true);
    // addItem('{\"name\": \"Ручка шариковая CORVINA (Италия) 51 Classic, корпус прозрачный, узел 1 мм, линия 0,7 мм, синяя\"}', true);
    // addItem('{\"name\": \"Ручка шариковая CORVINA (Италия) 51 Classic, корпус прозрачный, узел 1 мм, линия 0,7 мм, синяя\"}', false);
    // addItem('{\"name\": \"Ручка шариковая CORVINA (Италия) 51 Classic, корпус прозрачный, узел 1 мм, линия 0,7 мм, синяя\"}', false);
    // addItem('{\"name\": \"Ручка шариковая CORVINA (Италия) 51 Classic, корпус прозрачный, узел 1 мм, линия 0,7 мм, синяя\"}', false);
    // addItem('{\"name\": \"Ручка шариковая CORVINA (Италия) 51 Classic, корпус прозрачный, узел 1 мм, линия 0,7 мм, синяя\"}', false);
}

function getData() {
    var request = $.ajax({
        url: "http://localhost:60015/",
        type: "GET"
    });

    request.done(function (msg) {
        $("#log").html(msg);
    });

    request.fail(function (jqXHR, textStatus) {
        alert("Request failed: " + textStatus);
    });
}

function popUpShow() {
    $('#popup1').show();
}

function popUpHide() {
    $('#popup1').hide();
}

function addItem(str, value) {
    // let json = JSON.parse(str);
    let json = str;
    let element;
    if (value) {
        element = document.getElementById('gallery-primary');
    } else {
        element = document.getElementById('gallery-secondary');
    }

    element.innerHTML
        += '<div class="item" itemid="' + json.id + '"><img src="image.png"><p class="price">' + (Math.random() * 10000).toString().substring(0, 6) + ' ₽</p><p class="availability">' + Math.floor(Math.random() * 100) + ' предложения</p><p class="description">' + str.substring(0, 42) + "..." + '</p><button class="select" onclick="javascript:popUpShow()"><p>Выбрать</p></button></div>';
}