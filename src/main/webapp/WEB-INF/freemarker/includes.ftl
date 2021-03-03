[#ftl]
[#macro head]
<head>
  <meta charset=utf-8/>
  <meta name=viewport content="width=device-width, initial-scale=1.0">
  <title>[@spring.message code="example.title"/] - Freemarker</title>
  <link rel=stylesheet href=/static/css/bootstrap.min.css>
  <script src=/webjars/jquery/3.6.0/jquery.min.js defer></script>
  <script src=/static/js/bootstrap.min.js defer></script>
</head>
[/#macro]

[#macro pageTitle]
<div class=page-header>
  <h1>[@spring.message code="example.title"/] - Freemarker</h1>
</div>
[/#macro]

[#macro scripts]
[/#macro]