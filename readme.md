# EasyCSV  [![Release](https://jitpack.io/v/talhahasanzia/EasyCSV.svg)](https://jitpack.io/#talhahasanzia/EasyCSV/0.1)  [![GitHub issues](https://img.shields.io/github/issues/talhahasanzia/EasyCSV.svg)](https://github.com/talhahasanzia/EasyCSV/issues)   [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
CSV Parser for Android



## Release
Available Version:  [0.1](https://github.com/talhahasanzia/EasyCSV/releases/tag/0.1) on [jitpack.io](https://jitpack.io/#talhahasanzia/EasyCSV/0.1) 


## Library Source
[Jump to library source.](https://github.com/talhahasanzia/EasyCSV/tree/master/easycsvlibrary/src/main/java/com/talhahasanzia/csv)

## Getting Started

### Adding the library

In your project level gradle, add:
```
    maven { url "http://jitpack.io" }
```

In your app level gradle **(4.0+)**, add:
```
    implementation 'com.github.talhahasanzia:EasyCSV:0.1'
```
for gradle versions **below 4.0** use:
```
    compile 'com.github.talhahasanzia:EasyCSV:0.1'
```
## Using in your project
- Use built-in csv parser by providing CSV file path to the [EasyCSV](https://github.com/talhahasanzia/EasyCSV/blob/master/easycsvlibrary/src/main/java/com/talhahasanzia/csv/lib/EasyCSV.java) class like:
```
  EasyCSV easyCSV = new EasyCSV(new AssetSource(context, "sample.csv"), new ArrayParser(), new ParseCallback<SampleObject[]>()...);
  easyCSV.readCSV();
 ```
- Receive results in callbacks:
```
    @Override
    public void onParsingSuccess(SampleObject[] result) {
        // success
    }

    @Override
    public void onParsingFailure(ParseException e) {
        // failure
    }
```

- Add your own parsers using [Parser](https://github.com/talhahasanzia/EasyCSV/blob/master/easycsvlibrary/src/main/java/com/talhahasanzia/csv/core/Parser.java) interface.
- Add your own source using [Source](https://github.com/talhahasanzia/EasyCSV/blob/master/easycsvlibrary/src/main/java/com/talhahasanzia/csv/core/Source.java) interface.
- Currently only 1 source type is supported, that is [AssetSource](https://github.com/talhahasanzia/EasyCSV/blob/master/easycsvlibrary/src/main/java/com/talhahasanzia/csv/sources/AssetSource.java), meaning you can specify CSV files in your [assets](https://github.com/talhahasanzia/EasyCSV/tree/master/app/src/main/assets) folder.
- A generic [ArrayParser](https://github.com/talhahasanzia/EasyCSV/blob/master/easycsvlibrary/src/main/java/com/talhahasanzia/csv/parsers/ArrayParser.java) is implemented, which returns csv data into 2D array. 
- For illustration purposes, a [SampleObject](https://github.com/talhahasanzia/EasyCSV/blob/master/easycsvlibrary/src/main/java/com/talhahasanzia/csv/models/SampleObject.java) class is used in [ObjectParser](https://github.com/talhahasanzia/EasyCSV/blob/master/easycsvlibrary/src/main/java/com/talhahasanzia/csv/parsers/SampleObjectParser.java) to show how can you write generic parsers to directly convert csv fields into java classes.
- Feel free to report issues and contribute.
- Few source classes are empty, their implementation will be available soon.
  


## Contributing

- Contributions are welcomed as long as they dont break the code. Please create an issue and have a discussion before pull request.
- There is still WIP so dont hesitate to report issues or pull requests.
- Also, if you created a skin based on this library you can create a pull request and we will add it in official release.


## Hosting

Thanks to jitpack.io! Hosted at: https://jitpack.io/#talhahasanzia/EasyCSV/

## Authors

* **Talha** - *Initial work* - [@talhahasanzia](https://github.com/talhahasanzia)

## License

This project is licensed under the Apache 2.0 License - see the [LICENSE.md](https://github.com/talhahasanzia/anaclock/blob/master/LICENSE) file for details.

*Sources from Android and Android APIs are subject to the licensing terms as per Android Open Source Project (AOSP).*


## Code Credits
- File reading from [this answer on SOF](https://stackoverflow.com/a/9544781/4856761).
- Comma delimitation logic [from here](https://stackoverflow.com/a/15739087/4856761)
