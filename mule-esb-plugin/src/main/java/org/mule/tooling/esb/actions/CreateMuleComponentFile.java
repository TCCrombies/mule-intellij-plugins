package org.mule.tooling.esb.actions;

import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import org.mule.tooling.esb.templates.MuleFileTemplateDescriptorManager;
import org.mule.tooling.esb.util.MuleIcons;

public class CreateMuleComponentFile extends CreateFileFromTemplateAction implements DumbAware {


    public static final String MULE_CONFIGURATION = "Create Mule Component";

    public CreateMuleComponentFile() {
        super("Mule Component", "Create New Mule Component.", MuleIcons.MuleIcon);
    }

    @Override
    protected void buildDialog(Project project, PsiDirectory psiDirectory, CreateFileFromTemplateDialog.Builder builder) {
        builder.setTitle(MULE_CONFIGURATION)
                .addKind("Mule Configuration", MuleIcons.MuleFileType, MuleFileTemplateDescriptorManager.MULE_CONFIGURATION_FILE)
                .addKind("MUnit Test", MuleIcons.MUnitFileType, MuleFileTemplateDescriptorManager.MUNIT_FILE)
                .addKind("DataWeave", MuleIcons.DataFileType, MuleFileTemplateDescriptorManager.DATA_WEAVE_FILE)
                .addKind("MEL Script", MuleIcons.MelFileType, MuleFileTemplateDescriptorManager.MEL_FILE)
                .addKind("RAML File", MuleIcons.RamlFileType, MuleFileTemplateDescriptorManager.RAML_FILE);
    }

    @Override
    protected String getActionName(PsiDirectory directory, String newName, String templateName) {
        return "Create " + newName;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CreateMuleComponentFile;
    }
}
