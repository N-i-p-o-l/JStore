<script type="text/javascript">
  $(document).ready(function() {
    $.get("/weather", function (data) {
      $("#temp").html("Current temp in London " + data + "&deg;C");
    })
  });
</script>

<h2 align="center">Welcome to JStore!</h2>
<h3 id="temp" align="center"></h3>

