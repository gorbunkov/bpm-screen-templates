package com.company.bpmscreen.web.contract;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.bpmscreen.entity.Contract;
import com.haulmont.bpm.entity.ProcInstance;
import com.haulmont.bpm.entity.ProcTask;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.Label;
import javax.annotation.Nullable;
import java.util.List;
import com.haulmont.bpm.gui.procattachment.ProcAttachmentsFrame;
import com.haulmont.bpm.gui.procactor.ProcActorsFrame;
import com.haulmont.bpm.gui.proctask.ProcTasksFrame;

import com.haulmont.bpm.gui.procactions.ProcActionsFrame;
import javax.inject.Inject;

public class ContractEdit extends AbstractEditor<Contract> {

    private static final String PROCESS_CODE = "contractApproval";

    @Inject
    protected DataManager dataManager;

    @Inject
    protected Label processStateLabel;

    @Inject
    protected ProcActionsFrame procActionsFrame;

    @Inject
    protected ProcTasksFrame procTasksFrame;
    

    @Inject
    protected ProcActorsFrame procActorsFrame;
    

    @Inject
    protected ProcAttachmentsFrame procAttachmentsFrame;
    

    @Override
    protected void postInit() {
        initProcActionsFrame();

        ProcInstance procInstance = procActionsFrame.getProcInstance();
        if (procInstance != null) {
            procTasksFrame.setProcInstance(procInstance);
            procTasksFrame.refresh();

            procActorsFrame.setProcInstance(procInstance);
            procActorsFrame.refresh();

            procAttachmentsFrame.setProcInstance(procInstance);
            procAttachmentsFrame.refresh();
        }

        processStateLabel.setValue(getProcessState());
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

    @Nullable
    protected String getProcessState() {
        ProcInstance procInstance = procActionsFrame.getProcInstance();
        if (procInstance != null) {
            List<ProcTask> tasks = dataManager.loadList(LoadContext.create(ProcTask.class)
                .setQuery(LoadContext.createQuery("select t from bpm$ProcTask t where t.procInstance.id = :procInstance and t.endDate is null")
                    .setParameter("procInstance", procInstance)));
            if (!tasks.isEmpty()) return tasks.get(0).getName();
        }
        return null;
    }
}