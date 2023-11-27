//declaramos nuestas variables para delcarar la fecha
//del sistema. en este caso utilizaremos la segunda forma
//de declaracion de variable (let--- variable local)

//la palabra reservada "new" hace referencai a la creacion
//o instanciar un Objeto
let fecha = new Date();
//invocamos a los siguientes métodos:
//getDate(), obtener el día, el cual será guardado
//en la variable "dia"
let dia = fecha.getDate();
//getMonth() nos permite obtener el mes, el cual será
//guardado en la variable "mes"
let mes = fecha.getMonth()+1;
//getFullYear() nos permite obtener el año, el cual será
//guardado en la variable "anio"
let anio = fecha.getFullYear();
//para mostrar, la fecha usando DOM, accedemos al "id"
//de la etiqueta "div", usando el metodo getElementById()

//para poder asignar la fecha calculada anteriormente, usaremos la 
//propiedad innerHTML
document.getElementById("pf").innerHTML = "Fecha : " + dia + "/" + mes + "/" + anio;

//usaremos la funcion "reloj()", la cual nos permitira mostrar la hora.
function reloj()    {
    //instanciamos nuestro onh¿jeto Date()
    let fecha = new Date();
    //invocamos a los siguientes metodos:
    //getHours() nos ayudara a obtener la hora, la cual se guardara en la
    //variable "hora"
    let hora = fecha.getHours();
    //hetMinutes() permitira obtener los minutos, valor que sera guardado en
    //la variable "minutos"
    let minutos = fecha.getMinutes();
    //getSeconds() nos ayudara a obtener los segundos, la cual se guardara en la
    //variable "segundos"
    let segundos = fecha.getSeconds();

    //Para imprimir la Hora, usando DOM, accedemos al id de la etiqueta "div"
    //Usando el metodo getElementById
    document.getElementById("ph").innerHTML = "Hora : " + hora + ":" + minutos + ":" + segundos;
    
    //El metodo setTimeout() nos permite que, despues de un tiempo determionado, en este caso,
    //un segungo(1000ms), se haga el llamado a la funcion reloj()
    setTimeout("reloj()",1000);
    
}
//Haremos que, al actualizar nuestra pagina, se ejecute la funcion. Para ellos utilizaremos
//el metodo setAttribute, al cual le pasaremos dos parametros: el evento "onload", que nos 
//ayudara a cumplir nuestro objetivo y ademas, como segundo parametro, la funcion que se va a
//ejecutar

document.body.setAttribute("onload","reloj()");


