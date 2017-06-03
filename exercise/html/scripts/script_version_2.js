$(function () {

    $.ajax('http://localhost:8082/api/books/', {
        method: 'GET'
    }).then(function (data) {
        $("#booksList").html(""); //adeiazoume to html
        $.each(data, function (indexInArray, book) { // gia kathe vivlio gemizei ti lista
			
			var liElement= $('<li class="list-group-item"><a href="" onclick="return false;">'+book.name+'</a> </li>');
			$("#booksList").append(liElement);
			liElement.click(function () {

				$.ajax('http://localhost:8082/api/books/' + book.id, { // GET by Id
					method: 'GET'
				}).then(function (book) {

					$("#name").html(book.name);
					$("#author").html(book.author);
					$("#isbn").html(book.isbn);

					$("#rentals").empty();
					$("#rented").hide();
					$("#overdue").hide();
					$("#overdueDays").html("");

					if (book.isRented) {
						$("#rented").show();
					}
					
					if ( !isNaN(book.overdueDays) && book.overdueDays > 0) {
						$("#overdue").show();
						$("#overdueDays").html(book.overdueDays);
					}
					
					// Iterate through book's rentals
					$.each(book.rentals, function (indexInArray, rental) {
										
						var rentalRow = '<tr><td>' + rental.personName + '</td><td>' + rental.date + '</td>';
						if (rental.returnDate === null) {
							rentalRow += '<td class="text-danger">Not returned</td>';
						} else {
							rentalRow += '<td>' + rental.returnDate + '</td>';
						}
						rentalRow += '</tr>';
						$("#rentals").append(rentalRow);
					});
					
					$("#bookDetails").show();
					
				},function(err){
					// error handling
					$("#name").html('<li class="list-group-item"><div class="alert alert-danger text-center">Network error. '+
										err.status+' Couln\'t retrieve book details</div></li>');
					$("#rentals").empty();
					$("#rented").hide();
					$("#overdue").hide();
					$("#author").empty();
					$("#isbn").empty();
					$("#bookDetails").show();
				}
				);
			});
		});					
    },function(err){
		// error handling of the GET list of books
		var liElement= $('<li class="list-group-item"><div class="alert alert-danger text-center">Network error '+
						err.status+' . Couln\'t retrieve list of books</div></li>');
		$("#booksList").append(liElement);			
	});
});

