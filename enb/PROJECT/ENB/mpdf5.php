<?php
include("/MPDF/mpdf.php");
$mpdf=new mPDF();
$mpdf->WriteHTML('<p>Hallo World</p>');
$html="<table>";
$html.="<tr>";
for($i=1;$i<10;$i++)
{
$html.="<td>".$i."</td>";
}
$html.="</tr>";
$html.="</table>";
$mpdf->WriteHTML($html);
$mpdf->Output('filename.pdf');
?>