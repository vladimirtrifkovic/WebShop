$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();
		
		// /country/findById/?id=1
		
		var href = $(this).attr('href');
		//ispis  podataka u formu koja se edituje
		$.get(href, function(author, status ){
			$('#idEdit').val(author.id);
			$('#nameEdit').val(author.name);
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