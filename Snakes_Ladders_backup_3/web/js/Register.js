/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
              
                         $('#uname').focus(function(){
            
                $('#us').html('');
            }).blur(function(){
             
             
            match = /^\s*[a-zA-Z][a-zA-Z0-9,\s]+\s*$/;
            var uname = $('#uname').val();
            if(uname==''){
           $('#us').html('<font color="white" style="font-size:9pt">Username Cannot Be Empty</font>');
            }else if(!match.test(uname)){
            $('#us').html('<font color="white" style="font-size:9pt">Enter a Valid Username</font>');
             } else if(uname.length<5 || uname.length>10){
            $('#us').html('<font color="white" style="font-size:9pt">Username Should be Between 5 and 10 Characters</font>'); 
             }
            });
            
             $('#pass').focus(function(){
            
              $('#ps').html('');
            }).blur(function(){
             
            var pass = $('#pass').val();
            if(pass==''){
             
                  $('#ps').html('<font color="white" style="font-size:9pt">Password Cannot Be Empty</font>');
            }else  if(pass.match(/^[A-Za-z0-9]/)){         
                   if(pass.length<5 || pass.length>10){
                   $('#ps').html('<font color="white" style="font-size:9pt">Password Must be 5 to Characters Long</font>');
                 }
             }else{
              $('#ps').html('<font color="white" style="font-size:9pt">Enter a Valid Password</font>');
             }
             
            });
            
             $('#pass1').focus(function(){
             
              $('#pss').html('');
            }).blur(function(){
            
            var pass = $('#pass1').val();
            if(pass==''){
             $('#pass1').css('background','pink');
                  $('#pss').html('<font color="white" style="font-size:9pt">Password Cannot Be Empty</font>');
            }else  if(pass.match(/^[A-Za-z0-9]/)){         
                   if(pass.length<5 || pass.length>10){
                   $('#pss').html('<font color="white" style="font-size:9pt">Password Must be 5 to Characters Long</font>');
                 } else if($('#pass').val()!=$('#pass1').val()){
                   $('#pss').html('<font color="white" style="font-size:9pt">Both Passwords Must be Same</font>');
                 }
             }else{
              $('#pss').html('<font color="white" style="font-size:9pt">Enter a Valid Password</font>');
             }
             
            });
              $('#fname').focus(function(){
             
              $('#fn').html('');
            }).blur(function(){
            
            var fname = $('#fname').val();
            if(fname==''){
             $('#fname').css('background','pink');
                  $('#fn').html('<font color="white" style="font-size:9pt">Firstname Cannot Be Empty</font>');
            }else  if(fname.match(/^[A-Za-z0-9]/)){         
                   if(fname.length<5 || fname.length>20){
                   $('#fn').html('<font color="white" style="font-size:9pt">Firstname Must be 5 to 20 Characters Long</font>');
                 } 
             }else{
              $('#fn').html('<font color="white" style="font-size:9pt">Enter a Valid Firstname</font>');
             }
             
            });
            
               $('#lname').focus(function(){
            
              $('#ln').html('');
            }).blur(function(){
             
            var fname = $('#lname').val();
            if(fname==''){
             $('#lname').css('background','pink');
                  $('#ln').html('<font color="white" style="font-size:9pt">Lastname Cannot Be Empty</font>');
            }else  if(fname.match(/^[A-Za-z0-9]/)){         
                   if(fname.length<5 || fname.length>20){
                   $('#ln').html('<font color="white" style="font-size:9pt">Lastname Must be 5 to 20 Characters Long</font>');
                 } 
             }else{
              $('#ln').html('<font color="white" style="font-size:9pt">Enter a Valid Lastname</font>');
             }
             
            });
             $('#email').focus(function(){
             
              $('#em').html('');
            }).blur(function(){
             
            var fname = $('#email').val();
            if(fname==''){
             $('#email').css('background','pink');
                  $('#em').html('<font color="white" style="font-size:9pt">Email Cannot Be Empty</font>');
            }else  if(fname.match(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i)){         
                    
             }else{
              $('#em').html('<font color="white" style="font-size:9pt">Enter a Valid Email</font>');
             }
             
            });
               $('#addr').focus(function(){
            
              $('#ad').html('');
            }).blur(function(){
             
            var fname = $('#addr').val();
            if(fname==''){
             $('#addr').css('background','pink');
                  $('#ad').html('<font color="white" style="font-size:9pt">Address Cannot Be Empty</font>');
            }else  if(fname.match(/^[A-Za-z0-9._-]+/)){         
                   
             }else{
              $('#ad').html('<font color="white" style="font-size:9pt">Enter a Valid Address</font>');
             }
             
            });
            
               $('#sq').focus(function(){
                  
               }).blur(function(){
               
               });
               
               $('#sqa').focus(function(){
                  
                  $('#sa').html('');
               }).blur(function(){
               var sq = $('#sq').val();
               var sqa = $('#sqa').val();
               if(sq!='' && sqa==''){
                   $('#sa').html('<font color="white" style="font-size:9pt">Enter Valid Answer to the Question </font>');
               }
               
               });
              $('#alte').focus(function(){
             
              $('#ae').html('');
            }).blur(function(){
             
            var fname = $('#alte').val();
            if(fname!=''){
              if(fname.match(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i)){         
                    
             }else{
              $('#ae').html('<font color="white" style="font-size:9pt">Enter a Valid Email</font>');
            } }
             if($('#em').val()==$('#alte').val()){
                   $('#ae').html('<font color="white" style="font-size:9pt">Email and alternate cannot be the same.</font>');
                 }
                 
                 
            });   
               
               $('form').submit(function(){
                     var uname = $('#uname').val();
                     var pass = $('#pass').val();
                     var pass1 = $('#pass1').val();
                     var fname = $('#fname').val();
                     var lname = $('#lname').val();
                     var email = $('#email').val();
                     var gender = $('#gender').val();
                     
                     var addr = $('#addr').val();
                     var sq = $('#sq').val();
                     var sqa = $('#sqa').val();
                     var alte = $('#alte').val();
                     
                     match = /^\s*[a-zA-Z][a-zA-Z0-9,\s]+\s*$/;
            var uname = $('#uname').val();
            if(uname==''){
            $('#uname').css('background','pink');
                  $('#us').html('<font color="white" style="font-size:9pt">Username Cannot Be Empty</font>');
            }else if(!match.test(uname)){
            $('#us').html('<font color="white" style="font-size:9pt">Enter a Valid Username</font>');
             } else if(uname.length<5 || uname.length>10){
            $('#us').html('<font color="white" style="font-size:9pt">Username Should be Between 5 and 10 Characters</font>'); 
             }
              
               var pass = $('#pass').val();
            if(pass==''){
             $('#pass').css('background','pink');
                  $('#ps').html('<font color="white" style="font-size:9pt">Password Cannot Be Empty</font>');
            }else  if(pass.match(/^[A-Za-z0-9]/)){         
                   if(pass.length<5 || pass.length>10){
                   $('#ps').html('<font color="white" style="font-size:9pt">Password Must be 5 to Characters Long</font>');
                 }
             }else{
              $('#ps').html('<font color="white" style="font-size:9pt">Enter a Valid Password</font>');
             }
             
             var pass = $('#pass1').val();
            if(pass==''){
             $('#pass1').css('background','pink');
                  $('#pss').html('<font color="white" style="font-size:9pt">Password Cannot Be Empty</font>');
            }else  if(pass.match(/^[A-Za-z0-9]/)){         
                   if(pass.length<5 || pass.length>10){
                   $('#pss').html('<font color="white" style="font-size:9pt">Password Must be 5 to Characters Long</font>');
                 } else if($('#pass').val()!=$('#pass1').val()){
                   $('#pss').html('<font color="white" style="font-size:9pt">Both Passwords Must be Same</font>');
                 }
             }else{
              $('#pss').html('<font color="white" style="font-size:9pt">Enter a Valid Password</font>');
             }
              var fname = $('#fname').val();
            if(fname==''){
             $('#fname').css('background','pink');
                  $('#fn').html('<font color="white" style="font-size:9pt">Firstname Cannot Be Empty</font>');
            }else  if(fname.match(/^[A-Za-z0-9]/)){         
                   if(fname.length<5 || fname.length>20){
                   $('#fn').html('<font color="white" style="font-size:9pt">Firstname Must be 5 to 20 Characters Long</font>');
                 } 
             }else{
              $('#fn').html('<font color="white" style="font-size:9pt">Enter a Valid Firstname</font>');
             }
            
             var fname = $('#lname').val();
            if(fname==''){
             $('#lname').css('background','pink');
                  $('#ln').html('<font color="white" style="font-size:9pt">Lastname Cannot Be Empty</font>');
            }else  if(fname.match(/^[A-Za-z0-9]/)){         
                   if(fname.length<5 || fname.length>20){
                   $('#ln').html('<font color="white" style="font-size:9pt">Lastname Must be 5 to 20 Characters Long</font>');
                 } 
             }else{
              $('#ln').html('<font color="white" style="font-size:9pt">Enter a Valid Lastname</font>');
             }
             var email = $('#email').val();
            if(email==''){
             $('#email').css('background','pink');
                  $('#em').html('<font color="white" style="font-size:9pt">Email Cannot Be Empty</font>');
            }else  if(email.match(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i)){         
                    
             }else{
              $('#em').html('<font color="white" style="font-size:9pt">Enter a Valid Email</font>');
             } 
             
             var fname = $('#addr').val();
            if(fname==''){
             $('#addr').css('background','pink');
                  $('#ad').html('<font color="white" style="font-size:9pt">Address Cannot Be Empty</font>');
            }else  if(fname.match(/^[A-Za-z0-9._-]+/)){         
                   
             }else{
              $('#ad').html('<font color="white" style="font-size:9pt">Enter a Valid Address</font>');
             } 
             var gender=$('#gender').val();
            if(gender==''){
              $('#gd').html('<font color="white" style="font-size:9pt">Gender Cannot Be Empty</font>');
            }
            
            var sq=$('#sq').val();
            var sqa=$('#sqa').val();
            if(sq=='' && sqa!=''){
                $('#sa').html('<font color="white" style="font-size:9pt">Fill the Question First</font>');
            }else if(sq!='' && sqa==''){
               $('#sa').html('<font color="white" style="font-size:9pt">Answer Cannot be Empty</font>');
            }
            var alt=$('#alte').val();
            if(alt!=''){
                if(alt.match(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i)){
                
                }else {
                $('#alte').css('background','pink');
                $('#ae').html('<font color="white" style="font-size:9pt">Enter a Valid Email Id</font>');
                }
            }
            if(alt==email)
                {
                    $('#ae').html('<font color="white" style="font-size:9pt">both emails cannot be same</font>');
                }
            if(uname!='' && pass!='' && pass1!='' && fname!=''&& lname !='' && email!='' && gender!=''&&alte!=email){
            
           return true;              
                
       
            }else{
                
                return false;
            }
            });   
            
              
               });