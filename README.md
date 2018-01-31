# bpm-screen-templates

The project contains BPM screen templates for CUBA.Studio.

## BPM Entity Editor Template

The **BPM entity editor** template is used for creation of entity editor that has a process actions frame related to specific business process. The process code should be specified in the **Process code** property value.

![BPM entity editor template](https://github.com/gorbunkov/bpm-screen-templates/blob/master/screenshots/bpm-editor-studio-template.png)

The **Display process tasks** checkbox tells whether a component for displaying a list process tasks with their owners, outcomes and comments should be added to the entity editor.

The **Display process actors** checkbox tells whether a component for displaying a list process actors should be added to the entity editor.

The **Display process attachments** checkbox tells whether a component for displaying a list process attachments should be added to the entity editor.

The source code of the template is available in this [folder](https://github.com/gorbunkov/bpm-screen-templates/tree/master/studio-templates/screen/bpm-editor-screen)

## BPM Process Form Template

The **BPM process form template** creates a skeleton for the process form frame. To make the form available for the process modeler, it should be registered as mentioned in the [documentation](https://doc.cuba-platform.com/bpm-6.7/bpm.html#process_forms)

The source code of the template is available in this [folder](https://github.com/gorbunkov/bpm-screen-templates/tree/master/studio-templates/screen/bpm-process-form)



