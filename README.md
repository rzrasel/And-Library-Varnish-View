# And-Library-Varnish-View-Spinal-List-Drawer
And Library Varnish View Spinal List Drawer

### GIT Command
```git_command
git init
git remote add origin https://github.com/rzrasel/And-Library-Varnish-View.git
git remote -v
git fetch && git checkout And-Library-Varnish-View-Spinal-List-Drawer
```

#### Release "AAR" File
```build_aar
- Go to right panel > gradle
    - Go to > Project Main Tree (your-library-project)
    - Go to > build
    - Click > assembleRelease
```

Or

```build_aar
- Go to right panel > gradle
    - Go to > libraryvarnishspinallistdrawer (your-library-project)
    - Go to > build
    - Click > assembleRelease
    - Or (gradlew assemble)
```

Library Project (AAR) Directory

```library_project_aar_dir
your-library-project
    |- build
        |- outputs
            |- aar
                |- appframework-debug.aar
                 - appframework-release.aar
```

AAR Library Usages

```usages_library_project_arr
allprojects {
    repositories {
        jcenter()
        flatDir {
            dirs 'libs'
        }
    }
}

Or

repositories {
    mavenCentral()
    flatDir {
        dirs 'libs' //this way we can find the .aar file in libs folder
    }
}

compile(name: 'your-library-project', ext: 'aar')
```