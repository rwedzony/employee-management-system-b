$(document).ready(function() {
    if($("#user").text()!="admin"){
        $(".edit-button").attr("disabled",true)
        $(".delete-button").attr("disabled",true)
        $("#new-emp-button").addClass("disabled")
    }

    $('#calendar').fullCalendar({
    }
    )
});
