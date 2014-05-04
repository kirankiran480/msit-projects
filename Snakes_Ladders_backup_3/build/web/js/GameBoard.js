/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function frame()
{
    var r=Math.ceil(Math.random()*6);
    var dice1=document.getElementById("dice");
    //alert("js/dice"+r+".PNG");
    if(r==1)
        {
            alert("1");
    dice1.src="js/dice"+1+".PNG";
        }
        
        else if(r==2)
        {
            alert("2");
    dice1.src="js/dice"+2+".PNG";
        }
        
        if(r==3)
        {
            alert("3");
    dice1.src="js/dice"+3+".PNG";
        }
        
        if(r==4)
        {
            alert("4");
    dice1.src="js/dice"+4+".PNG";
        }
        
        if(r==5)
        {
            alert("5");
    dice1.src="js/dice"+5+".PNG";
        }
        
        if(r==6)
        {
            alert("6");
    dice1.src="js/dice"+6+".PNG";
        }
        $('#valuedice').val(r);
        document.forms['diceform'].submit();
        return r;
}



