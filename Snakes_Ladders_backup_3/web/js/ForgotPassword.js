/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function()
{
   $('input[name="loginname"]').focus(function()
{   
}).blur(function()
{
var loginn=$(this).val();
    if(loginn=='')
        {
            $('#ln').html("<p>Enter the login name!</p>");
            $('#ln').css("color","white");
        }
});

$('input[name="Answer"]').focus(function()
{   
}).blur(function()
{
var ans=$(this).val();
    if(ans=='')
        {
            $('#ansent').html("<p>Enter the login name!</p>");
            $('#ansent').css("color","white");
        }
});

$('input[name="email"]').focus(function()
{   
}).blur(function()
{
var em=$(this).val();
    if(em=='')
        {
            $('#altem').html("<p>Enter the login name!</p>");
            $('#altem').css("color","white");
        }
});

$('button').click(function()
{
var loginn=$(this).val();
    if(loginn=='')
        {
            $('#ln').html("<p>Enter the login name!</p>");
            $('#ln').css("color","white");
        }

var ans=$(this).val();
    if(ans=='')
        {
            $('#ansent').html("<p>Enter the login name!</p>");
            $('#ansent').css("color","white");
        }


var em=$(this).val();
    if(em=='')
        {
            $('#altem').html("<p>Enter the login name!</p>");
            $('#altem').css("color","white");
        }

var ques=$('#secques').val();
    if(ques=='q')
        {
            $('#selq').html("<p>Select any color</p>");
            $('#selq').css("color","white");
        }
        
if( loginn!=''&&ans!=''&&em!=''&&ques=='q')
    {
        return true;
    }
    else
        {
            return false;
        }
    
});

$('input[name="Recpass"]').click(function()
{
var loginn=$(this).val();
    if(loginn=='')
        {
            $('#ln').html("<p>Enter the login name!</p>");
            $('#ln').css("color","white");
        }

var ques=$('#secques').val();
    if(ques=='Select')
        {
            $('#selq').html("<p>Select any color</p>");
            $('#selq').css("color","white");
        }
        
var ans=$(this).val();
    if(ans=='')
        {
            $('#ansent').html("<p>Enter the login name!</p>");
            $('#ansent').css("color","white");
        }


var em=$(this).val();
    if(em=='')
        {
            $('#altem').html("<p>Enter the login name!</p>");
            $('#altem').css("color","white");
        }

if( loginn!=''&&ques!="Select"&&ans!=''&&em!='')
    {
        return true;
    }
    else
        {
            return false;
        }
    
});
});


