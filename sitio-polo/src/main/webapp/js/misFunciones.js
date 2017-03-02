
function aumentarValueEnUno(e)
{

  var elemento= document.getElementById(e);


    elemento.value++

}

function disminuirValueEnUno(e)
{
  var elemento= document.getElementById(e);
  if(elemento.value!=0)
  {
    elemento.value--
  }
}
