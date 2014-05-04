function validateForm()
{
    var firstname = document.register.firstname;
if(firstname.value.length<5 || firstname.value.length>10 || (/[\W]|[\d]/).test(firstname.value))
{
alert("Please enter a valid firstname with alphabets and between 5 to 10");
firstname.focus();
return false;  
  
}
var lastname = document.register.lastname;
if(lastname.value.length<5 || lastname.value.length>20 || (/[\W]|[\d]/).test(lastname.value))
{
alert("Please enter a valid lastname with alphabets and between 5 to 20");
lastname.focus();
return false;  
  
}
var uname = document.register.login;
if(uname.value.length<5 || uname.value.length>20 || (/[\W]|[\d]/).test(uname.value) || (/\s/).test(uname.value))
{
alert("please enter a valid username");
uname.focus();
return false;
}
    var db=document.forms ["register"]["dob"].value;
    //alert(db);
    if (db =="")
    {
        alert("Enter your date of birth");
        document.register.dob.focus() ;
        return false;
    }
    if (db.substring(0,4) < "1950" )
    {
        alert("your are too old to play");
        document.register.dob.focus() ;
        return false;
    }
    else if (db.substring(0,4)> "2008")
    {
        alert("your are too young to play");
        document.register.dob.focus() ;
        return false;
    }

    var radios = document.getElementsByName("sex");
    var formValid = false;

    var i = 0;
    while (formValid==false && i<radios.length)
    {
        if (radios[i].checked)
            formValid = true;
        i++;
    }
    if (formValid==false)
    {
        alert("choose a gender !");
        return false;
    }
    var x=document.forms["register"]["mail"].value;
    var atpos=x.indexOf("@");
    var dotpos=x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
    {
        alert("Not a valid e-mail address");
        document.forms["register"]["mail"].focus();
        return false;
    }

    var password = document.register.pwd.value;
    if(password.length<5 || password.length >10 || password.length ==0 )
    {
        alert("enter password correctly");
        return false;
    }
    var confirm_pass = document.register.pwd1.value;
    if(password != confirm_pass)
    {
        alert("entered password is not same ");
        return false;
    }
    var ques = document.register.secret.value;
    var ans = document.register.answer.value;
    if(ques != "select a question")
    {

        if(ans.length == 0)
        {
            alert("enter a answer");
            return false;
        }


    }
    else
    {
        if(ans.length != 0)
        {
            alert("select a question or leave blank");
            return false;

        }

 }
  
    return true;
}
