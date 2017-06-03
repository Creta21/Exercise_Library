$(function () {
    var $my = $('#myul');
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8082/api/books',
        success: function(books) {
            $.each(books, function(i, book) {
                var liElement = $('<li class="list-group-item"><a href="" onclick="return false;">'+ book.name +'</a></li>');
                $("#booksList").append(liElement);
                liElement.click(function () {
                    $.ajax({
                        type: 'GET',
                        url: 'http://localhost:8082/api/books/'+book.id,
                        success: function(bookDetail) {
                            $("#name").html(bookDetail.name);
                            $("#author").html(bookDetail.author);
                            $("#isbn").html(bookDetail.isbn);

                            $("#rentals").empty();
                            $("#rented").hide();
                            $("#overdue").hide();
                            $("#overdueDays").html("");

                            if (bookDetail.isRented) {
                                $("#rented").show();
                            }  

                            if ( !isNaN(bookDetail.overdueDays) && bookDetail.overdueDays > 0) {
                                $("#overdue").show();
                                $("#overdueDays").html(bookDetail.overdueDays);
                            }

                            // Iterate through book's rentals
                            $.each(bookDetail.rentals, function (indexInArray, rental) {
                                                
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

                        },
                        error: function(error){
                            // error handling
                            $("#name").html('<li class="list-group-item"><div class="alert alert-danger text-center">Network error. '+
                                                error.status+' Couln\'t retrieve book details</div></li>');
                            $("#rentals").empty();
                            $("#rented").hide();
                            $("#overdue").hide();
                            $("#author").empty();
                            $("#isbn").empty();
                            $("#bookDetails").show();
                        }
                    });
                });
            });
        },
        error: function(error){
            // error handling of the GET list of books
	    	var liElement= $('<li class="list-group-item"><div class="alert alert-danger text-center">Network error '+
			    		error.status +' . Couln\'t retrieve list of books</div></li>');
		    $("#booksList").append(liElement);	
        }
    });
});