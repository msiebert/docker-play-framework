var count = 0;
function nextLine() {
  var id = 'input' + count;
  count++;
  $('.terminal').append(
    '<span class="prompt">echo "<span id="' + id + '-span"></span><input id="' + id + '" type="text" placeholder="hello world" />" > /dev/null;</span>'
  );
  $('#' + id).keypress(function(e) {
    if (e.which == 13) {
      var text = $('#' + id).val();
      $('#' + id + '-span').text(text);
      $('#' + id).remove();

      $.ajax({
        url: '/',
        method: 'POST',
        data: {
          'text': text
        }
      }).done(function(result) {
        $('.terminal').append(
          '<span class="result">Successfully redirected "' + text + '" to /dev/null for the cloud.</span>'
        )
      }).fail(function(jqXHR) {
        $('.terminal').append(
          '<span class="result error">/dev/null in the cloud failed with status code ' + jqXHR.responseText + '.</span>'
        );
      }).always(function() {
        nextLine();
      });
    }
  });
  $('#' + id).focus();
}

$(document).ready(function() {
  nextLine();
});
