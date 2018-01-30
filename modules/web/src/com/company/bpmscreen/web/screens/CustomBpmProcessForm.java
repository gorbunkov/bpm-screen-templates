package com.company.bpmscreen.web.screens;

import com.google.common.base.Strings;
import com.haulmont.bpm.entity.ProcInstance;
import com.haulmont.bpm.entity.ProcTask;
import com.haulmont.bpm.form.ProcFormDefinition;
import com.haulmont.bpm.form.ProcFormParam;
import com.haulmont.bpm.gui.form.AbstractProcForm;
import com.haulmont.cuba.gui.WindowParam;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class CustomBpmProcessForm extends AbstractProcForm {

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