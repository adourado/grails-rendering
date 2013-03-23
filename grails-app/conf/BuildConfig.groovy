/*
 * Copyright 2010 Grails Plugin Collective
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
grails.work.dir = "target/workdir"
grails.project.class.dir = 'target/classes'
grails.project.test.class.dir = 'target/test-classes'
grails.project.test.reports.dir	= 'target/test-reports'
grails.project.docs.output.dir = 'target/docs' // for backwards-compatibility, the docs are checked into gh-pages branch

grails.release.scm.enabled = false

// Code Narc
codenarc.reports = {
	XmlReport('xml') {
		outputFile = 'target/test-reports/CodeNarcReport.xml'
		title = 'OAuth2 Provider Plugin Report'
	}
	HtmlReport('html') {
		outputFile = 'target/test-reports/CodeNarcReport.html'
		title = 'OAuth2 Provider Plugin Report'
	}
}

grails.project.dependency.resolution = {
	inherits( "global" )
	log "warn"
	repositories {
		grailsPlugins()
		grailsHome()
		grailsCentral()

		mavenLocal()
		mavenRepo "http://maven.springframework.org/milestone"	// For spring-security-oauth provider
		mavenCentral()
	}
	dependencies {
		compile("org.xhtmlrenderer:core-renderer:R8")
		compile("com.lowagie:itext:2.1.0")
		/*test("org.apache.pdfbox:pdfbox:1.0.0") {
			exclude 'jempbox'
			exported = false
		}*/
	}
	plugins {
		compile(":spring-events:1.0", ":tomcat:$grailsVersion", ":hibernate:$grailsVersion") {
			exported = false
		}
		/*test(":spock:0.5-groovy-1.7") {
			exported = false
		}*/
	}
}

if (appName == "grails-rendering") {
	grails.plugin.location.'pdf-plugin-test' = "plugins/pdf-plugin-test"
}
