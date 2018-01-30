<%
if (copyright) {
        println '/*'
        println " * ${copyright.replace('\n', '\n * ')}"
        println ' */'
} else {
        print ""
}
%>package ${packageName};

import com.haulmont.bpm.entity.ProcInstance;
import com.haulmont.bpm.entity.ProcTask;
import com.haulmont.bpm.form.ProcFormDefinition;
import com.haulmont.bpm.gui.form.AbstractProcForm;
import com.haulmont.cuba.gui.WindowParam;
import com.google.common.base.Strings;
import java.util.HashMap;
import java.util.Map;

<%if (classComment) {%>
${classComment}<%}%>
public class ${controllerName} extends AbstractProcForm {

    @WindowParam(name = "procTask")
    protected ProcTask procTask;

    @WindowParam(name = "procInstance")
    protected ProcInstance procInstance;

    @WindowParam(name = "formDefinition")
    protected ProcFormDefinition formDefinition;

    @WindowParam
    protected String caption;

    @Override
    public void init(Map<String, Object> params){
        super.init(params);
        if (!Strings.isNullOrEmpty(caption)) {
            setCaption(caption);
        }
    }

    @Override
    public String getComment() {
        return null;
    }

    @Override
    public Map<String, Object> getFormResult() {
        return new HashMap<>();
    }
}