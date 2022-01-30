function getJoke() {
    axios.get("https://v2.jokeapi.dev/joke/Programming?type=twopart")
        .then(response => {
            console.log(response.data);
            document.getElementById('setup').value = response.data.setup;
            document.getElementById('delivery').value = response.data.delivery;
        })
        .catch(error => {
            console.error(error);
            document.getElementById('setup').value = "ERROR EN LA CONSULTA: " + error;
            document.getElementById('delivery').style.display = "none";
        });
}


function postJoke() {
let setup = document.getElementById("setup").value;
let delivery = document.getElementById("delivery").value;
console.log(setup);

    $.ajax ({
        type: "POST",
        url: "./index.php",
        data: {
            setup: setup,
            delivery: delivery,
        },
        success: function() {
            alert("Datos insertados correctamente")
        },
        error: function () {
            alert("Error en la conexión")
        }
    })
}