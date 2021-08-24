$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();
		
		// /country/findById/?id=1
		
		var href = $(this).attr('href');
		//ispis  podataka u formu koja se edituje
		$.get(href, function(music, status ){
			$('#idEdit').val(music.id);
			$('#titleEdit').val(music.title);
			$('#publishDateEdit').val(music.publishDate);
			$('#descriptionEdit').val(music.description);
			$('#priceEdit').val(music.price);
			$('#publishingHouseEdit').val(music.publishingHouse);
			$('#durationEdit').val(music.duration);
			$('#cdNumberEdit').val(music.cdNumber);
			$('#authorsEdit').val(music.authors);
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