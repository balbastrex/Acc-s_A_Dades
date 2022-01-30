<?php
if(isset($_POST["setup"])){
    $setup = $_POST["setup"];
    $delivery = $_POST["delivery"];
    $servidor = "localhost";
    $usuario = "root";
    $password = "";
    $dbname = "jokeDb";
    $conexion = mysqli_connect($servidor, $usuario, $password, $dbname);

    if (!$conexion) {
        echo "Error en la conexion a MySQL: ".mysqli_connect_error();
        exit();
    }

    $sql = "INSERT INTO jokes (setup,delivery) VALUES ('".$setup."','".$delivery."')";

    if (mysqli_query($conexion, $sql)) {
        echo "Registro insertado correctamente.";
    } else {
        echo "Error: " . $sql . "<br>" . mysqli_error($conexion);
    }
}
?>
