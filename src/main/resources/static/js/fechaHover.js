// En tu script
function fechaHover() {
    // Obtener la fecha actual
    const fechaActual = new Date();
    const diaSemana = fechaActual.toLocaleDateString('es-ES', { weekday: 'long' });
    const dia = fechaActual.getDate();
    const mes = fechaActual.toLocaleDateString('es-ES', { month: 'long' });
    const anio = fechaActual.getFullYear();

    // Formatear la fecha como "Domingo, 30 de junio de 2024"
    const fechaFormateada = `${diaSemana}, ${dia} de ${mes} de ${anio}`;

    // Mostrar la fecha al hacer hover
    const fechaHover = document.getElementById("fechaHover");
    fechaHover.innerText = fechaFormateada;
    fechaHover.classList.remove("d-none"); // Mostrar el elemento

}

fechaHover();
