function setupFoundation() {
  $(document).foundation();
}

function patchCheckBoxes() {
  $('input[type="checkbox"]').change(function () {
    $(this).val(this.checked ? 'true' : 'false');
  });
}

function setupTag() {
  $('#tags_1').tagsInput({
    width: $("#tags_1").parent().parent().width(),
    defaultText: 'Aggiungi Tag'
  });
}


function setupPagination() {
  $("#allQuestions").easyPaginate({
    paginateElement: '.media-object',
    elementsPerPage: 5,
    effect: 'climb'
  });
}

$(document).ready(function () {
  setupFoundation();
  patchCheckBoxes();
  setupTag();
  setupPagination();
});