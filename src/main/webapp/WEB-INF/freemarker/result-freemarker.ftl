[#ftl]
[#import "includes.ftl" as example/]
<!DOCTYPE html>
<html>
[@example.head/]
<body>
<div class="container-fluid">
[@example.pageTitle/]

  <dl class="dl-horizontal">
    <dt>[@spring.message code="example.name"/]</dt>
    <dd>${form.name?html}</dd>
    <dt>[@spring.message code="example.email"/]</dt>
    <dd>${form.email?html}</dd>
    <dt>[@spring.message code="example.word"/]</dt>
    <dd>${form.word?html}</dd>
  </dl>
</div>
[@example.scripts/]
</body>
</html>