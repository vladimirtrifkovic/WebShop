$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();
		
		// /country/findById/?id=1
		
		var href = $(this).attr('href');
		//ispis  podataka u formu koja se edituje
		$.get(href, function(actor, status ){
			$('#idEdit').val(actor.id);
			$('#nameEdit').val(actor.name);
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