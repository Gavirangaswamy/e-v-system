
function regValidation(){
    var fName = document.getElementById("fName").value;
    var lName = document.getElementById("lName").value;
    var username = document.getElementById("username").value;
    var password = document.getElementById("pass").value;
    var cnfpassword = document.getElementById("cnfpassword").value;
    var phone = document.getElementById("phone").value;
    var email = document.getElementById("email").value;
    var msg = document.getElementById("message");

    if(username!==""){
        if(username.length<6 || username.length>12 ){
            msg.innerHTML='<i class="fas fa-exclamation-circle" style ="font-size:20px;"></i>'+"   Username is invalid";
            if(username!=username.match(/^[a-z0-9]+$/)){
                msg.innerHTML='<i class="fas fa-exclamation-circle" style ="font-size:20px;"></i>'+"   Username is invalid";
             }
        }else if(fName===""){
            msg.innerHTML='<i class="fas fa-exclamation-circle" style ="font-size:20px;"></i>'+"   First Name is Empty";
        }else if(lName===""){
            msg.innerHTML='<i class="fas fa-exclamation-circle" style ="font-size:20px;"></i>'+"   Last Name is Empty";
        }else if(password===""){
             msg.innerHTML='<i class="fas fa-exclamation-circle" style ="font-size:20px;"></i>'+"   Password is Empty";
        }else if(cnfpassword===""){
            msg.innerHTML = '<i class="fas fa-exclamation-circle" style ="font-size:20px;"></i>'+"   Comfirm Password is Empty";
        }else if(cnfpassword!==password){
            msg.innerHTML = '<i class="fas fa-exclamation-circle" style ="font-size:20px;"></i>'+"   password mismatch";
        }else if(phone.length<10){
            msg.innerHTML = '<i class="fas fa-exclamation-circle" style ="font-size:20px;"></i>'+"   Invalid Phone Number";
        }else{
            msg.innerHTML = "Registration Successful"; 
            if(msg.innerHTML==="Registration Successful")
            {
                msg.style.color="green";
            }
        }
    }else{
        msg.innerHTML='<i class="fas fa-exclamation-circle" style ="font-size:20px"></i>'+ " Username is Empty";
    }
    
}
    
var password = document.getElementById("pass");
var msg = document.getElementById("pmsg");
var str = document.getElementById("strength");

password.addEventListener("input", function(){
    if(password.value.length>0){
        msg.style.display = "block";
    }
    else{
        msg.style.display = "none";
    }
    if(password.value.length<4){
        str.innerHTML = "Week"
        str.style.color = "#ff5925"
        password.style.borderColor = "#ff5925"
    }
    else if(password.value.length>=4 && password.value.length<8){
        str.innerHTML = "Medium"
        str.style.color = "yellow";
        password.style.borderColor = "yellow"
    }
    else if(password.value.length>=9){
        str.innerHTML = "Strong"
        str.style.color = "green"
        password.style.borderColor = "green"
        // msg.style.display = "none";
    }
    
});