function hey() {
    let string = $("#formInput").val();
    console.log(string);

    let xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.open("POST", "http://localhost:8080/example", true);
    xmlHttpRequest.send(string);
}