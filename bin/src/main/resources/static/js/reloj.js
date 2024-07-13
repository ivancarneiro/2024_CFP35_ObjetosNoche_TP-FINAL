function mueveReloj(){
    fechaActual = new Date()


    const hora = fechaActual.getHours()
    const minuto = fechaActual.getMinutes()
    const segundo = fechaActual.getSeconds()

    horaImprimible =    hora.toString().padStart(2, '0') + " : " + 
                        minuto.toString().padStart(2, '0') + " : " + 
                        segundo.toString().padStart(2, '0')

    document.getElementById("reloj").innerText = horaImprimible

    setTimeout("mueveReloj()",1000)
}