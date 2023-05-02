package RepositoryTests;

import BaseTest.BaseTest;
import Models.Xml.Dependency;
import Models.Xml.Project;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AuthorizationTest extends BaseTest {

    @Test
    @Parameters({"URL","GitLogin","GitPass"})
    public void EnterToLoginPage(String url,String username,String password)
    {
        basePage.OpenPage(url);
        loginPage
                .EnterCredentials(username,password)
                .SignIn();
    }
    @Test(dependsOnMethods = {"EnterToLoginPage"}, alwaysRun = true)
    @Parameters({"SearchQuery"})
     public void SearchRepositoryByName(String query) throws InterruptedException, IOException {
        gitPage
                .EnterSearchQuery(query)
                .GoToSearchedElement();
        gitRepositoryViewer
                .GetPomXml();
    }
    @Test(dependsOnMethods = {"SearchRepositoryByName"})
    @Parameters({"TestNgVersion"})
    public void CheckDependencyVersion(String testNgVersion) throws IOException {
        gitRepositoryViewer
                .ShowFileAsRaw();
        String xmlString = gitRepositoryViewer.GetRawedText();
        Project xmlObject = xmlDeserializer.PomXmlDeserialize(xmlString);
        List<Dependency> dependenciesList = xmlObject.getDependencies();

        for (Dependency dependency : dependenciesList) {
            System.out.println("Artifact ID: " + dependency.getArtifactId());
            System.out.println("Version: " + dependency.getVersion());
        }

        Dependency searchedDependency = new Dependency();
        Optional<Dependency> testngDependency = dependenciesList.stream()
                .filter(dependency -> "testng".equals(dependency.getArtifactId()))
                .findFirst();

        if (testngDependency.isPresent()) {
            searchedDependency = testngDependency.get();
        } else {
            System.out.println("testng dependency - не найдено");
        }
        Assert.assertEquals( searchedDependency.getVersion(),testNgVersion);
    }



}



