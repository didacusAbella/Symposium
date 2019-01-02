/* Inserite in questa funzione tutte le funzionalità Javascript che possono servirvi */
$(document).ready(function(){
  /* Setup Foundation */
  $(document).foundation();
  $('input[type="checkbox"]').change(function () {
		$(this).val(this.checked ? 'true': 'false');
  });
});