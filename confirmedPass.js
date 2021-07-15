function checkPass(){
    var pass1 = document.getElementById('pass1');
    var pass2 = document.getElementById('pass2');

    var message = document.getElementById('confirmMessage');

    var goodColor = "#66cc66";    var badColor = "#ff6666";

    if(pass1.value == pass2.value) {

        pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match!"

    } else {  
        pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
    }
}  