<style>
/*! normalize.css v3.0.2 | MIT License | git.io/normalize */

/**
* 1. Set default font family to sans-serif.
* 2. Prevent iOS text size adjust after orientation change, without disabling
*    user zoom.
*/

html {
font-family: sans-serif; /* 1 */
-ms-text-size-adjust: 100%; /* 2 */
-webkit-text-size-adjust: 100%; /* 2 */
}

/**
* Remove default margin.
*/

body {
margin: 0;
}

/* HTML5 display definitions
========================================================================== */

/**
* Correct `block` display not defined for any HTML5 element in IE 8/9.
* Correct `block` display not defined for `details` or `summary` in IE 10/11
* and Firefox.
* Correct `block` display not defined for `main` in IE 11.
*/

article,
aside,
details,
figcaption,
figure,
footer,
header,
hgroup,
main,
menu,
nav,
section,
summary {
display: block;
}

/**
* 1. Correct `inline-block` display not defined in IE 8/9.
* 2. Normalize vertical alignment of `progress` in Chrome, Firefox, and Opera.
*/

audio,
canvas,
progress,
video {
display: inline-block; /* 1 */
vertical-align: baseline; /* 2 */
}

/**
* Prevent modern browsers from displaying `audio` without controls.
* Remove excess height in iOS 5 devices.
*/

audio:not([controls]) {
display: none;
height: 0;
}

/**
* Address `[hidden]` styling not present in IE 8/9/10.
* Hide the `template` element in IE 8/9/11, Safari, and Firefox < 22.
*/

[hidden],
template {
display: none;
}

/* Links
========================================================================== */

/**
* Remove the gray background color from active links in IE 10.
*/

a {
background-color: transparent;
}

/**
* Improve readability when focused and also mouse hovered in all browsers.
*/

a:active,
a:hover {
outline: 0;
}

/* Text-level semantics
========================================================================== */

/**
* Address styling not present in IE 8/9/10/11, Safari, and Chrome.
*/

abbr[title] {
border-bottom: 1px dotted;
}

/**
* Address style set to `bolder` in Firefox 4+, Safari, and Chrome.
*/

b,
strong {
font-weight: bold;
}

/**
* Address styling not present in Safari and Chrome.
*/

dfn {
font-style: italic;
}

/**
* Address variable `h1` font-size and margin within `section` and `article`
* contexts in Firefox 4+, Safari, and Chrome.
*/

h1 {
font-size: 2em;
margin: 0.67em 0;
}

/**
* Address styling not present in IE 8/9.
*/

mark {
background: #ff0;
color: #000;
}

/**
* Address inconsistent and variable font size in all browsers.
*/

small {
font-size: 80%;
}

/**
* Prevent `sub` and `sup` affecting `line-height` in all browsers.
*/

sub,
sup {
font-size: 75%;
line-height: 0;
position: relative;
vertical-align: baseline;
}

sup {
top: -0.5em;
}

sub {
bottom: -0.25em;
}

/* Embedded content
========================================================================== */

/**
* Remove border when inside `a` element in IE 8/9/10.
*/

img {
border: 0;
}

/**
* Correct overflow not hidden in IE 9/10/11.
*/

svg:not(:root) {
overflow: hidden;
}

/* Grouping content
========================================================================== */

/**
* Address margin not present in IE 8/9 and Safari.
*/

figure {
margin: 1em 40px;
}

/**
* Address differences between Firefox and other browsers.
*/

hr {
-moz-box-sizing: content-box;
box-sizing: content-box;
height: 0;
}

/**
* Contain overflow in all browsers.
*/

pre {
overflow: auto;
}

/**
* Address odd `em`-unit font size rendering in all browsers.
*/

code,
kbd,
pre,
samp {
font-family: monospace, monospace;
font-size: 1em;
}

/* Forms
========================================================================== */

/**
* Known limitation: by default, Chrome and Safari on OS X allow very limited
* styling of `select`, unless a `border` property is set.
*/

/**
* 1. Correct color not being inherited.
*    Known issue: affects color of disabled elements.
* 2. Correct font properties not being inherited.
* 3. Address margins set differently in Firefox 4+, Safari, and Chrome.
*/

button,
input,
optgroup,
select,
textarea {
color: inherit; /* 1 */
font: inherit; /* 2 */
margin: 0; /* 3 */
}

/**
* Address `overflow` set to `hidden` in IE 8/9/10/11.
*/

button {
overflow: visible;
}

/**
* Address inconsistent `text-transform` inheritance for `button` and `select`.
* All other form control elements do not inherit `text-transform` values.
* Correct `button` style inheritance in Firefox, IE 8/9/10/11, and Opera.
* Correct `select` style inheritance in Firefox.
*/

button,
select {
text-transform: none;
}

/**
* 1. Avoid the WebKit bug in Android 4.0.* where (2) destroys native `audio`
*    and `video` controls.
* 2. Correct inability to style clickable `input` types in iOS.
* 3. Improve usability and consistency of cursor style between image-type
*    `input` and others.
*/

button,
html input[type="button"], /* 1 */
input[type="reset"],
input[type="submit"] {
-webkit-appearance: button; /* 2 */
cursor: pointer; /* 3 */
}

/**
* Re-set default cursor for disabled elements.
*/

button[disabled],
html input[disabled] {
cursor: default;
}

/**
* Remove inner padding and border in Firefox 4+.
*/

button::-moz-focus-inner,
input::-moz-focus-inner {
border: 0;
padding: 0;
}

/**
* Address Firefox 4+ setting `line-height` on `input` using `!important` in
* the UA stylesheet.
*/

input {
line-height: normal;
}

/**
* It's recommended that you don't attempt to style these elements.
* Firefox's implementation doesn't respect box-sizing, padding, or width.
*
* 1. Address box sizing set to `content-box` in IE 8/9/10.
* 2. Remove excess padding in IE 8/9/10.
*/

input[type="checkbox"],
input[type="radio"] {
box-sizing: border-box; /* 1 */
padding: 0; /* 2 */
}

/**
* Fix the cursor style for Chrome's increment/decrement buttons. For certain
* `font-size` values of the `input`, it causes the cursor style of the
* decrement button to change from `default` to `text`.
*/

input[type="number"]::-webkit-inner-spin-button,
input[type="number"]::-webkit-outer-spin-button {
height: auto;
}

/**
* 1. Address `appearance` set to `searchfield` in Safari and Chrome.
* 2. Address `box-sizing` set to `border-box` in Safari and Chrome
*    (include `-moz` to future-proof).
*/

input[type="search"] {
-webkit-appearance: textfield; /* 1 */
-moz-box-sizing: content-box;
-webkit-box-sizing: content-box; /* 2 */
box-sizing: content-box;
}

/**
* Remove inner padding and search cancel button in Safari and Chrome on OS X.
* Safari (but not Chrome) clips the cancel button when the search input has
* padding (and `textfield` appearance).
*/

input[type="search"]::-webkit-search-cancel-button,
input[type="search"]::-webkit-search-decoration {
-webkit-appearance: none;
}

/**
* Define consistent border, margin, and padding.
*/

fieldset {
border: 1px solid #c0c0c0;
margin: 0 2px;
padding: 0.35em 0.625em 0.75em;
}

/**
* 1. Correct `color` not being inherited in IE 8/9/10/11.
* 2. Remove padding so people aren't caught out if they zero out fieldsets.
*/

legend {
border: 0; /* 1 */
padding: 0; /* 2 */
}

/**
* Remove default vertical scrollbar in IE 8/9/10/11.
*/

textarea {
overflow: auto;
}

/**
* Don't inherit the `font-weight` (applied by a rule above).
* NOTE: the default cannot safely be changed in Chrome and Safari on OS X.
*/

optgroup {
font-weight: bold;
}

/* Tables
========================================================================== */

/**
* Remove most spacing between table cells.
*/

table {
border-collapse: collapse;
border-spacing: 0;
}

td,
th {
padding: 0;
}

/*! HTML5 Boilerplate v5.0 | MIT License | http://h5bp.com/ */

html {
color: #222;
font-size: 1em;
line-height: 1.4;
}

::-moz-selection {
background: #b3d4fc;
text-shadow: none;
}

::selection {
background: #b3d4fc;
text-shadow: none;
}

hr {
display: block;
height: 1px;
border: 0;
border-top: 1px solid #ccc;
margin: 1em 0;
padding: 0;
}

audio,
canvas,
iframe,
img,
svg,
video {
vertical-align: middle;
}

fieldset {
border: 0;
margin: 0;
padding: 0;
}

textarea {
resize: vertical;
}

.browserupgrade {
margin: 0.2em 0;
background: #ccc;
color: #000;
padding: 0.2em 0;
}


/* ==========================================================================
Author's custom styles
========================================================================== */

html,
body {
height: 100%;
}




.content {
flex: 1 0 auto;
position:relative;
}

.wrapper {

margin: 0 auto;
width:1000px;

}

.main-wrapper{
display: flex;
flex-direction: column;
height: 100%;

}



.login-wrapper {
text-align:center;
}

.login-form {
background-color: #2d2d2d;
margin-bottom: 10px;
width: 500px;
margin: 0 auto 29px;
padding: 75px 0px;
border-radius: 14px;
}

.login-form input{
text-align:center;
}

.sidebar{
width:17%;

float:left;
/*border-right:1px solid;
border-color:lightgrey;*/
}

.main-stripe{
width:81%;
height:100%;
float:left;
margin-top: 6px;
margin-left:15px;
padding-bottom: 28px;

border-color:lightgrey;
}

.user-pic {
margin-right:10px;
float:left;
}

.wall-post{
background: lightgrey;
padding: 11px;
margin: 0 0px 10px;
position:relative;

}

.wall-post-news{
padding-left: 73px;
}

.wall-post-delete {
display: inline-block;
float: right;
position:absolute;
right:10px;
top:8px;
text-decoration:none;
color:inherit;

}
.wall-post:nth-child(even){
background:#eaeaea;
}

.wall-post-new{
width: 597px;
float: right;
}

.friend-pic{
float: left;
margin-right: 9px;
height: 102px;
}

.news-pic{
float: left;
margin-right: 9px;
height: 89px;
margin-left: -59px
}

.friend{
min-height: 132px
}

.author-name{
font-weight: bold;;
}
.friend-name{
font-weight: bold;;
}

.wall-post-add{

margin-left: 507px;
}

.chat-message{
padding: 11px;
margin: 0 0px 10px;
position:relative;
padding-left: 73px;


}

.big-bottom{
padding-bottom:178px !important;
}

.wall-post-update{
    position: absolute;
    right: 25px;
    top: 8px;
    text-decoration: none;
    color: inherit;
}

.send-button{
display: block;
background: #d5d5d5;
width: auto;
padding: 6px;
text-align: center;
text-decoration: none;
color: white;
border-radius: 13px;
}

.chat-send{
margin-left: 507px;
}

.message-enter-wrap{
text-align: center;
position: absolute;
bottom: 9px;
right: 102px;

}

.wall-post-author{
background:inherit !important;

clear:both;
}

.user-name{
background: lightgrey;
margin-bottom: 8px;
padding: 3px 9px;
}
.dark{
color:white;
background:#2d2d2d;
}
footer{
padding: 4px 10px;
flex: 0 0 auto;
height:60px;
}
header{
width:100%;
}

.sidebar-menu li{
list-style:none;
}

.sidebar-menu li a{
text-decoration:none;
color:inherit;
display: inline-block;
width: 102px;
padding-left: 9px;
margin-left: -9px;
}

.logout{
text-decoration:none;
color:inherit;
}

.logout:hover{
text-decoration:underline;

}

.sidebar-menu li a:hover{
background: lightgrey;
}

.main-title{

padding: 4px 10px;
}


.main-title a{
color:white;
padding: 4px 10px;
}

.logout{
display:inline-block;
float:right;

}


.pagination li{
list-style:none;
display:inline-block;

}


.pagination li a{
text-decoration:none;
color:inherit;

}
.pagination li a:hover{
text-decoration:underline;

}
.pagination{
padding:0;
}
.pagination-wrap{
width: 50%;
text-align: center;
margin: 0 auto;
}


/* ==========================================================================
Media Queries
========================================================================== */

@media only screen and (min-width: 35em) {

}

@media print,
(-o-min-device-pixel-ratio: 5/4),
(-webkit-min-device-pixel-ratio: 1.25),
(min-resolution: 120dpi) {

}

/* ==========================================================================
Helper classes
========================================================================== */

.hidden {
display: none !important;
visibility: hidden;
}

.visuallyhidden {
border: 0;
clip: rect(0 0 0 0);
height: 1px;
margin: -1px;
overflow: hidden;
padding: 0;
position: absolute;
width: 1px;
}

.visuallyhidden.focusable:active,
.visuallyhidden.focusable:focus {
clip: auto;
height: auto;
margin: 0;
overflow: visible;
position: static;
width: auto;
}

.invisible {
visibility: hidden;
}

.clearfix:before,
.clearfix:after {
content: " ";
display: table;
}

.clearfix:after {
clear: both;
}

.clearfix {
*zoom: 1;
}

/* ==========================================================================
Print styles
========================================================================== */

@media print {
*,
*:before,
*:after {
background: transparent !important;
color: #000 !important;
box-shadow: none !important;
text-shadow: none !important;
}

a,
a:visited {
text-decoration: underline;
}

a[href]:after {
content: " (" attr(href) ")";
}

abbr[title]:after {
content: " (" attr(title) ")";
}

a[href^="#"]:after,
a[href^="javascript:"]:after {
content: "";
}

pre,
blockquote {
border: 1px solid #999;
page-break-inside: avoid;
}

thead {
display: table-header-group;
}

tr,
img {
page-break-inside: avoid;
}

img {
max-width: 100% !important;
}

p,
h2,
h3 {
orphans: 3;
widows: 3;
}

h2,
h3 {
page-break-after: avoid;
}
}

</style>