#!/usr/bin/env bash

git tag -l | grep step | xargs git tag -d

let i=1
for sha in $(git log --grep "This step" --reverse --pretty='%h')
do
    git tag -f step$i $sha
    let i=i+1
done
