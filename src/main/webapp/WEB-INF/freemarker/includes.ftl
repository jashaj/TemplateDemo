[#ftl]
[#macro head]
<head>
  <meta charset=utf-8/>
  <meta name=viewport content="width=device-width, initial-scale=1.0">
  <meta http-equiv=X-UA-Compatible content="IE=Edge">
  <title>[@spring.message code="example.title"/] - Freemarker</title>
  <link rel=stylesheet href=/static/css/bootstrap.min.css>
</head>
[/#macro]

[#macro pageTitle]
<div class=page-header>
  <h1>[@spring.message code="example.title"/] - Freemarker</h1>
</div>
[/#macro]

[#macro scripts]
<script src=/webjars/jquery/3.4.1/jquery.min.js></script>
<script src=/static/js/bootstrap.min.js></script>
[/#macro]