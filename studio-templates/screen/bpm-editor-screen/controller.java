<%
if (copyright) {
    println '/*'
    println " * ${copyright.replace('\n', '\n * ')}"
    println ' */'
} else {
    print ""
}
%>package ${packageName};

import com.haulmont.cuba.gui.components.AbstractEditor;
import ${entity.fqn};
<%if (displayProcessAttachments) {%>
import com.haulmont.bpm.entity.ProcAttachment;
import com.haulmont.cuba.gui.app.core.file.FileDownloadHelper;
import com.haulmont.cuba.gui.components.Table;<%}%>
import com.haulmont.bpm.gui.procactions.ProcActionsFrame;
import javax.inject.Inject;
<%if (classComment) {%>
${classComment}<%}%>
public class ${controllerName} extends AbstractEditor<${entity.className}> {

    private static final String PROCESS_CODE = "${processCode}";

    @Inject
    private ProcActionsFrame procActionsFrame;
<%if (displayProcessAttachments) {%>
    @Inject
    private Table<ProcAttachment> attachmentsTable;<%}%>

    @Override
    protected void postInit() {
        <%if (displayProcessAttachments) {%>FileDownloadHelper.initGeneratedColumn(attachmentsTable, "file");<%}%>
        initProcActionsFrame();
    }

    private void initProcActionsFrame() {
        procActionsFrame.initializer()
            .setBeforeStartProcessPredicate(this::commit)
            .setAfterStartProcessListener(() -> {
                showNotification(getMessage("processStarted"), NotificationType.HUMANIZED);
                close(COMMIT_ACTION_ID);
            })
            .setBeforeCompleteTaskPredicate(this::commit)
            .setAfterCompleteTaskListener(() -> {
                showNotification(getMessage("taskCompleted"), NotificationType.HUMANIZED);
                close(COMMIT_ACTION_ID);
            })
            .init(PROCESS_CODE, getItem());
    }
}