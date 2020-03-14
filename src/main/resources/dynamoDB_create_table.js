var params = {
    TableName: 'dev-users',
    KeySchema: [ // The type of of schema.  Must start with a HASH type, with an optional second RANGE.
        {
            AttributeName: 'userId',
            KeyType: 'HASH',
        },
    ],
    AttributeDefinitions: [
        {
            AttributeName: 'userId',
            AttributeType: 'S',
        },
    ],
    ProvisionedThroughput: {
        ReadCapacityUnits: 1,
        WriteCapacityUnits: 1,
    },
};
dynamodb.createTable(params, function(err, data) {
    if (err) ppJson(err); // an error occurred
    else ppJson(data); // successful response
});