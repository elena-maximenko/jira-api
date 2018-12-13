function hey() {
    let string = $("#formInput").val();
    $.post('http://localhost:8080/example', string);
}