$(document).ready(function(){
    $('#student-table').hide();
    $("button#getAllStudents").click(function(){
        $('#student-table').show();
        $('.student-info').remove();
          
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8888/students',
            success: function(studentsArray) {
                var studentsTbody = $('#student-table-body');
                $.each(studentsArray, function(index, student) {
                    var studentInfo = '<tr class="student-info">';
                    studentInfo += '<th scope="row">' + student.id + '</th>';
                    studentInfo += '<td>' + student.name + '</td>';
                    studentInfo += '<td>' + student.age + '</td>';
                    studentInfo += '<td>' + student.mobile + '</td>';
                    studentInfo += '<td>' + student.address + '</td>';
                    studentInfo += '</tr>';
                    studentsTbody.append(studentInfo);
                })
            },
            error: function() {alert('FAILURE!');
          }
        })
    });
    
  $("#student-registration-form").submit(function (event) {
      event.preventDefault();
      StudentRegisterAjaxSubmit();
  });
  
  function StudentRegisterAjaxSubmit() {
      var student = {}
      student["id"] = $("#id").val();
      student["name"] = $("#name").val();
      student["age"] = $("#age").val();
      student["mobile"] = $("#mobile").val();
      student["address"] = $("#address").val();
      
      $.ajax({
          type: "POST",
          contentType: "application/json",
          url: "http://localhost:8888/students",
          data: JSON.stringify(student),
          dataType: 'json',
          success: function (data) {
              alert(student["name"] + " registered!");
              
          },
          error: function (e) {
              alert(student["name"] + " register failed!");
          }
      });
    }
   $('button#findbyid').click(function () {
    var id = $('#findId').val();
    $.ajax({
      type: 'GET',
      url: 'http://localhost:8888/students/' + id,
      success: function (student) {
        if (student.length == 0) {
          alert('No Student with that ID');
        } else {
          var studentByIdDiv = $('div#studentById');
          var studentInfo = '<ul class=" bg-warning">';
          studentInfo +=
            '<li class="list-group-item active">ID: ' + student.id + '</li>';
          studentInfo +=
            '<li class="list-group-item">Name: ' + student.name + '</li>';
          studentInfo +=
            '<li class="list-group-item">Age: ' + student.age + '</li>';
          studentInfo +=
            '<li class="list-group-item">Mobile Number: ' +
            student.mobileNumber +
            '</li>';
          studentInfo +=
            '<li class="list-group-item">Address: ' + student.address + '</li>';
          studentInfo += '</ul>';

          studentByIdDiv.prepend(studentInfo);
        }
      },
    });
  });
  $('button#deletebyid').click(function () {
    var id = $('#deletebyid').val();
    $.ajax({
      type: 'DELETE',
      url: 'http://localhost:8888/students/' + id,
      success: function (student) {
        alert('Student with ID ' + id + ' deleted from DB');
        location.reload(true);
      },
    });
  });
});