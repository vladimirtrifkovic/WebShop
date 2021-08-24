$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();
		
		// /country/findById/?id=1
		
		var href = $(this).attr('href');
		//ispis  podataka u formu koja se edituje
		$.get(href, function(book, status ){
			$('#idEdit').val(book.id);
			$('#titleEdit').val(book.title);
			$('#publishDateEdit').val(book.publishDate);
			$('#descriptionEdit').val(book.description);
			$('#priceEdit').val(book.price);
			$('#publishingHouseEdit').val(book.publishingHouse);
			$('#authorsEdit').val(book.authors);
		});
		
		$('#editModal').modal();
	});
	
	$('table #deleteButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$('#confirmDeleteButton').attr('href', href);
		
		$('#deleteModal').modal();
	});
});