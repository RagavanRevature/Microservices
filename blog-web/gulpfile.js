var gulp = require('gulp');
var args = require('yargs').argv;
var config = require('./gulp.config')();
var $ = require('gulp-load-plugins')({
    lazy: true
});

gulp.task('jslint', function() {
    return gulp
        .src(config.paths.js)
        .pipe($.if(args.verbose, $.print()))
        .pipe($.jscs())
        .pipe($.jshint())
        .pipe($.jshint.reporter('jshint-stylish', {
            verbose: true
        }))
        .pipe($.jshint.reporter('fail'));
});

gulp.task('beautify', function() {
    var lineFeed = osCheck();
    return gulp.src(config.paths.beautify, {
            base: './'
        })
        .pipe($.jsbeautifier({
            config: './beautify-settings.json',
            eol: lineFeed
        }))
        .pipe($.jsbeautifier.reporter())
        .pipe(gulp.dest('./'));
});

function osCheck() {
    var lineFeed;
    if (process.platform === 'win32') {
        lineFeed = '\r\n';
    } else if (process.platform === 'darwin' || process.platform === 'linux') {
        lineFeed = '\n';
    } else {
        var error = 'Unfamiliar operating system.';
        throw error;
    }

    return lineFeed;
}