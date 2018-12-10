function hey() {
    console.log('hey!');

    let xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.open("POST", "http://localhost:8080/example");
    xmlHttpRequest.send("gjsvhhv"); // insert data in here
}