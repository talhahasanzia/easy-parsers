# Easy Parsers  [![Release](https://jitpack.io/v/talhahasanzia/easy-parsers.svg)](https://jitpack.io/#talhahasanzia/easy-parsers/0.2)  [![GitHub issues](https://img.shields.io/github/issues/talhahasanzia/easy-parsers.svg)](https://github.com/talhahasanzia/easy-parsers/issues)   [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
*Custom Parser for Android.*


Customisable parser for Android in which "Parsers" and Csv "Sources" can act as plug and play to do the task of converting data from CSV rows and columns into Java objects. This was initially made for CSV parsing but looking at it flexibility to add parsers and sources was renamed to Easy Parsers since you can add any kind of source and parser to this library. (Or in your project while using this library)

**Here are some project specific terms:**

### Source
A source is a contract that defines text read from any source that contains csv data. The source always outputs data in String format which is then used by parser. The source can be anything from reading from local files in assets or raw folders to a network response or in something like where Android receives exported CSV files from another system. You can write source of any type and it will always be compatible with EasyCSV, if you want to add any "Source" to the main repo, I really encourage you to do so. This makes it really flexible to add any source type and use a common "Facade" class called [EasyParser](https://github.com/talhahasanzia/EasyCSV/blob/master/easycsvlibrary/src/main/java/com/talhahasanzia/csv/lib/EasyParser.java) in client code to acheive complex conversion task with clean code approach.


### Parser
A parser is nothing but a logic that defines how you convert string data coming out from source. Usually most of the work in parser is same. It only differs where the result type is specified by the caller. For eg, currently 2 result types are in the project, 2D array and SampleObject. Parser makes sure that the caller receives the data in the form it expected, either in 2D array or a custom object. This is so powerful in cases where CSV data has to be converted into SQL Database compatible data or in model classes of the project. Parser can be implemented in a way to return any object like array of ContentValues class type which can be directly inserted into database. Feel free to write your own customized parsers and if possible contribute in main repo!



## Release
Available Version:  [0.2](https://github.com/talhahasanzia/easy-parsers/releases/tag/0.1) on [jitpack.io](https://jitpack.io/#talhahasanzia/EasyCSV/0.1) 


## Library Source
[Jump to library source.](https://github.com/talhahasanzia/easy-parsers/tree/master/easycsvlibrary/src/main/java/com/talhahasanzia/csv)

## Getting Started

### Adding the library

In your project level gradle, add:
```
    maven { url "http://jitpack.io" }
```

In your app level gradle **(4.0+)**, add:
```
    implementation 'com.github.talhahasanzia:easy-parsers:0.2'
```
for gradle versions **below 4.0** use:
```
    compile 'com.github.talhahasanzia:easy-parsers:0.2'
```
## Using in your project
- Use built-in csv parser by providing CSV file path to the [EasyParser](https://github.com/talhahasanzia/easy-parsers/blob/master/easycsvlibrary/src/main/java/com/talhahasanzia/csv/lib/EasyParser.java) class like:
```
  EasyParser easyParser = new EasyParser(new AssetSource(context, "sample.csv"), new ArrayParser(), new ParseCallback<String[][]>()...);
  easyParser.parse();
 ```
- Receive results in callbacks:
```
    @Override
    public void onParsingSuccess(String[][] result) {
        // success
    }

    @Override
    public void onParsingFailure(ParseException e) {
        // failure
    }
```

- Add your own parsers using [Parser](https://github.com/talhahasanzia/easy-parsers/blob/master/easycsvlibrary/src/main/java/com/talhahasanzia/csv/core/Parser.java) interface.
- Add your own source using [Source](https://github.com/talhahasanzia/easy-parsers/blob/master/easycsvlibrary/src/main/java/com/talhahasanzia/csv/core/Source.java) interface.
- Currently only 1 source type is supported, that is [AssetSource](https://github.com/talhahasanzia/easy-parsers/blob/master/easycsvlibrary/src/main/java/com/talhahasanzia/csv/sources/AssetSource.java), meaning you can specify CSV files in your [assets](https://github.com/talhahasanzia/easy-parsers/tree/master/app/src/main/assets) folder.
- A generic [ArrayParser](https://github.com/talhahasanzia/easy-parsers/blob/master/easycsvlibrary/src/main/java/com/talhahasanzia/csv/parsers/ArrayParser.java) is implemented, which returns csv data into 2D array. 
- For illustration purposes, a SampleObject class is used in ObjectParser in the sample "app" module to show how can you write generic parsers to directly convert csv fields into java classes.
- Feel free to report issues and contribute.
- Few source classes are empty, their implementation will be available soon.
  


## Contributing

- Contributions are welcomed as long as they dont break the code. Please create an issue and have a discussion before pull request.
- There is still WIP so dont hesitate to report issues or pull requests.
- Also, if you created a skin based on this library you can create a pull request and we will add it in official release.


## Hosting

Thanks to jitpack.io! Hosted at: https://jitpack.io/#talhahasanzia/easy-parsers/

## Authors

* **Talha** - *Initial work* - [@talhahasanzia](https://github.com/talhahasanzia)

## License

This project is licensed under the Apache 2.0 License - see the [LICENSE.md](https://github.com/talhahasanzia/EasyCSV/blob/master/LICENSE) file for details.

*Sources from Android and Android APIs are subject to the licensing terms as per Android Open Source Project (AOSP).*


## Code Credits
- File reading from [this answer on SOF](https://stackoverflow.com/a/9544781/4856761).
- Comma delimitation logic [from here](https://stackoverflow.com/a/15739087/4856761)
