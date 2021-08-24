$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();
		
		// /country/findById/?id=1
		
		var href = $(this).attr('href');
		//ispis  podataka u formu koja se edituje
		$.get(href, function(video, status ){
			$('#idEdit').val(video.id);
			$('#titleEdit').val(video.title);
			$('#publishDateEdit').val(video.publishDate);
			$('#descriptionEdit').val(video.description);
			$('#priceEdit').val(video.price);
			$('#directorEdit').val(video.director);
			$('#durationEdit').val(video.duration);
			$('#dvdNumberEdit').val(video.dvdNumber);
			$('#actorsEdit').val(video.actors);
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