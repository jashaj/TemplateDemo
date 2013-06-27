[#ftl]
[#import "includes.ftl" as example/]
<!DOCTYPE html>
<html>
[@example.head/]
<body>
<div class=container-fluid>
[@example.pageTitle/]
  <form action=/freemarker method=post class=form-horizontal>
  [@spring.bind "form"/]
    <div class=control-group>
      <label for=name class=control-label>[@spring.message code="example.name"/]</label>

      <div class=controls>
      [@spring.formInput "form.name" "class=input-xlarge" /]
      </div>
    </div>
    <div class=control-group>
      <label for=email class=control-label>[@spring.message code="example.email"/]</label>

      <div class=controls>
      [#assign emailPlaceholder][@spring.message code="example.email.placeholder"/][/#assign]
      [@spring.formInput "form.email" "placeholder='${emailPlaceholder}' class=input-xlarge" "email" /]
      </div>
    </div>
    <div class=control-group>
      <label for=word class=control-label>[@spring.message code="example.pick-word"/]</label>

      <div class=controls>
      [@spring.formSingleSelect "form.word" words/]
      </div>
    </div>
    <div class=control-group>
      <div class=controls>
      [#assign submitValue][@spring.message code="example.submit"/][/#assign]
        <input type=submit class="btn btn-primary" value=${submitValue}>
      </div>
    </div>
  </form>
</div>
[@example.scripts/]
</body>
</html>