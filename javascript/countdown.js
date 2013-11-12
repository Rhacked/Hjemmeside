    var end = new Date("12/01/2013");
    
    var _second = 1000;
    var _minute = _second * 60;
    var _hour = _minute * 60;
    var _day = _hour * 24;
    var timer;
    
    function showRemaining(){
        var now = new Date();
        var distance = end.getTime()-now.getTime();
        if(distance<0){
            document.getElementById('downloadbutton').setAttribute("style","display: inline");
            document.getElementById('countdown').innerHTML = '0 dager 0 timer 0 minutter 0 sekunder';
            
            return;
        }
        
        var days = Math.floor(distance / _day);
        var hours = Math.floor((distance % _day) / _hour);
        var minutes = Math.floor((distance % _hour) / _minute);
        var seconds = Math.floor((distance % _minute)/ _second);
        
        document.getElementById('countdown').innerHTML = days+" dager "+hours+" timer "+minutes+" minutter "+seconds+" sekunder";
    }
    timer = setInterval(showRemaining, 1000);
